package hasanalmudev.belajarjavavalidation1;

import hasanalmudev.belajarjavavalidation1.Container.Data;
import hasanalmudev.belajarjavavalidation1.Container.DateInterger;
import hasanalmudev.belajarjavavalidation1.Container.Entry;
import hasanalmudev.belajarjavavalidation1.ekstractor.SampleData;
import hasanalmudev.belajarjavavalidation1.ekstractor.SampleDateInterger;
import hasanalmudev.belajarjavavalidation1.ekstractor.SampleEntry;
import org.junit.jupiter.api.Test;

public class ValueExtractorTest extends AbstractValidatorTest {

    @Test
    void testSampleData() {
        SampleData sampleData = new SampleData();
        sampleData.setData(new Data<>());
        sampleData.getData().setDate(" ");
        sampleData.getData().setDate("abkajjenfoaebahgiajlk");

        validate(sampleData);
    }

    @Test
    void testSampleEntry() {
        SampleEntry sampleEntry = new SampleEntry();
        sampleEntry.setEntry(new Entry<>());
        sampleEntry.getEntry().setKey(" ");
        sampleEntry.getEntry().setValue("");

        validate(sampleEntry);
    }

    @Test
    void testTypeGeneric() {
        SampleDateInterger sampleDateInterger = new SampleDateInterger();
        sampleDateInterger.setDateInterger(new DateInterger());
        sampleDateInterger.getDateInterger().setInteger(null);

        validate(sampleDateInterger);
    }
}
