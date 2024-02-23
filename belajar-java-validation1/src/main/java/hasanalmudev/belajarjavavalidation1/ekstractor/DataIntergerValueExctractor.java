package hasanalmudev.belajarjavavalidation1.ekstractor;

import hasanalmudev.belajarjavavalidation1.Container.DateInterger;
import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.UnwrapByDefault;
import jakarta.validation.valueextraction.ValueExtractor;

@UnwrapByDefault
public class DataIntergerValueExctractor implements
        ValueExtractor<@ExtractedValue(type = Integer.class) DateInterger> {
    @Override
    public void extractValues(DateInterger dateInterger, ValueReceiver valueReceiver) {
        valueReceiver.value(null, dateInterger.getInteger());
    }
}
