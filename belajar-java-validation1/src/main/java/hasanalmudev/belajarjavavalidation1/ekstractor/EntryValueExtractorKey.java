package hasanalmudev.belajarjavavalidation1.ekstractor;

import hasanalmudev.belajarjavavalidation1.Container.Entry;
import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.ValueExtractor;

public class EntryValueExtractorKey implements ValueExtractor<Entry<@ExtractedValue ?,?>> {
    @Override
    public void extractValues(Entry<?, ?> entry, ValueReceiver receiver) {
        receiver.keyedValue(null, "key", entry.getKey());
    }
}
