package helpers;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

import static helpers.LogHelper.SESSION_ID;
import static java.util.logging.Level.SEVERE;

public class VersionUtil {

    static Logger LOGGER = LogHelper.LOGGER;

    public static String getApplicationVersion(){
        MavenXpp3Reader reader = new MavenXpp3Reader();
        Model model;
        try {
            model = reader.read(new FileReader("pom.xml"));
        } catch (IOException | XmlPullParserException e) {
            LOGGER.log(SEVERE, "Cannot parse app version from pom.xml" + SESSION_ID, e);
            throw new RuntimeException(e);
        }
        return model.getVersion();
    }
}
