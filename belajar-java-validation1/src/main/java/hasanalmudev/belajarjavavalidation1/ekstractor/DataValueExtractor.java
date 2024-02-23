package hasanalmudev.belajarjavavalidation1.ekstractor;

import hasanalmudev.belajarjavavalidation1.Container.Data;
import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.ValueExtractor;

public class DataValueExtractor implements ValueExtractor<Data<@ExtractedValue ?>> {
    @Override
    public void extractValues(Data<?> data, ValueReceiver receiver) {
       receiver.value(null, data.getDate());
    }
}
