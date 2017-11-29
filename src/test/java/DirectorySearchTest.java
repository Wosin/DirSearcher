import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.dominwos.searching.FileSearcher;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( loader = AnnotationConfigContextLoader.class)
public class DirectorySearchTest {

    @Configuration
    static class ContextConfiguration {
        String filepath = "./src/test/resources/testDir";

        @Bean
        public FileSearcher fileSearcher() {
            FileSearcher fileSearcher = new FileSearcher(filepath);
            return fileSearcher;
        }
    }

    @Autowired
    FileSearcher fileSearcher;

    @Test
    public void checkFileFilterReturnsFilesFulfillingPredicate() {
        List<String> filesToBeFound = new ArrayList<>();
        filesToBeFound.add(".\\src\\test\\resources\\testDir\\Cat");
        filesToBeFound.add(".\\src\\test\\resources\\testDir\\Dog Cat");

        Collection<String> filesFound = fileSearcher.searchFile("Cat");

        Assert.assertEquals(2, filesFound.size());
        Assert.assertTrue(filesFound.containsAll(filesToBeFound));
    }

    @Test
    public void checkFileFilterPerformsOnlyFullWordMatches() {
        Collection<String> filesFound = fileSearcher.searchFile("Pup");

        Assert.assertTrue(filesFound.isEmpty());
    }

    @Test
    public void checkFileFilterPerformsOnlyFullSearchPhraseSearch() {
        Collection<String> filesFound = fileSearcher.searchFile("Puppy pup");

        Assert.assertTrue(filesFound.isEmpty());
    }

}