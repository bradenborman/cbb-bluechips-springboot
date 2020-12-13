package Borman.cbbbluechips.utilities;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStreamReader;

public class HtmlTemplateLoader {

    static Logger logger = LoggerFactory.getLogger(HtmlTemplateLoader.class);

    public static String loadFromTemplate(String fileName)  {
        try {
            return IOUtils.toString(new InputStreamReader(HtmlTemplateLoader.class.getResourceAsStream("/email-templates/" + fileName + ".html")));
        } catch (Exception e) {
            logger.error("Failed to get HTML template");
            return "";
        }
    }

}