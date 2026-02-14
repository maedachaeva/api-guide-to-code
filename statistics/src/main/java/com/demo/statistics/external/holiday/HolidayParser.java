package com.demo.statistics.external.holiday;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

@Component
public class HolidayParser {
    private static final DateTimeFormatter HOLIDAY_DATE_FORMAT = DateTimeFormatter.BASIC_ISO_DATE;

    public Set<LocalDate> parse(String xml) {
        Set<LocalDate> holidays = new HashSet<>();

        if (xml == null || xml.isBlank()) {
            return holidays;
        }

        try {
            // DOM
            Document doc = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder()
                    .parse(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)));

            NodeList items = doc.getElementsByTagName("item");

            for (int i = 0; i < items.getLength(); i++) {
                Node node = items.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element item = (Element) node;

                    NodeList locdateNodes = item.getElementsByTagName("locdate");
                    if (locdateNodes.getLength() == 0 || locdateNodes.item(0) == null) {
                        continue;
                    }

                    String locdate = locdateNodes.item(0).getTextContent();
                    if (locdate != null && !locdate.isBlank()) {
                        holidays.add(LocalDate.parse(locdate, HOLIDAY_DATE_FORMAT));
                    }
                }
            }

        } catch (Exception e) {
            // TODO: BusinessException 및 전역 예외 처리 적용
            throw new IllegalStateException("공휴일 XML 파싱 실패: " + e.getMessage(), e);
        }

        return holidays;
    }
}
