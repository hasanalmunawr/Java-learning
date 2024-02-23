package hasan.almu.dev;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.temporal.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class TemporalTest {

    @Test
    void createTemporal() {
        Temporal temporal = LocalDate.now();
        Temporal temporal1 = LocalTime.now();
        Temporal temporal3 = ZonedDateTime.now();
        Temporal temporal4 = Year.now();


        System.out.println(temporal);
        System.out.println(temporal1);
        System.out.println(temporal3);
        System.out.println(temporal4);
    }

    @Test
    void temporalAmmount() {
        Temporal temporalAmount = LocalDateTime.now();
        Temporal temporal = temporalAmount.plus(Duration.ofHours(48));
        Temporal temporal1 = temporalAmount.plus(Period.ofDays(3));

        System.out.println(temporalAmount);
        System.out.println(temporal);
        System.out.println(temporal1);
    }

    @Test
    void temporalUnit() {
        long temporal = ChronoUnit.DAYS.between(LocalDate.now(), LocalDate.of(2023, 12, 25));
        long temporal1 = ChronoUnit.MINUTES.between(LocalTime.now(), LocalTime.now().plusHours(2));
        long temporal2 = ChronoUnit.DAYS.between(LocalDate.of(2023, 01, 01), LocalDate.now());

        System.out.println(temporal);
        System.out.println(temporal1);
        System.out.println(temporal2);
    }

    @Test
    void temporalField() {
        Temporal temporal = LocalDateTime.now();

        System.out.println(temporal.get(ChronoField.YEAR_OF_ERA));
        System.out.println(temporal.get(ChronoField.MONTH_OF_YEAR));
        System.out.println(temporal.get(ChronoField.DAY_OF_MONTH));
        System.out.println(temporal.get(ChronoField.DAY_OF_WEEK));
    }

    @Test
    void temporalQuery() {
        Temporal temporal = LocalDateTime.now();
//        ingin memasukan ke dalam List dalam keaddan terpisah
        List<Integer> tanggal = temporal.query(new TemporalQuery<List<Integer>>() {
            ArrayList<Integer> newList = new ArrayList<>();
            @Override
            public List<Integer> queryFrom(TemporalAccessor temporalAccessor) {
                ArrayList<Integer> newList = new ArrayList<>();

                newList.add(temporal.get(ChronoField.YEAR));
                newList.add(temporal.get(ChronoField.MONTH_OF_YEAR));
                newList.add(temporal.get(ChronoField.DAY_OF_MONTH));

                return  newList;
            }
        });

        System.out.println(tanggal);

//        with lambadha
        Temporal myBornDate = LocalDate.of(2004, 07, 23);

        List<Integer> hasanDate = myBornDate.query(date -> {
            ArrayList<Integer> dateList = new ArrayList<>();
            dateList.add(date.get(ChronoField.YEAR));
            dateList.add(date.get(ChronoField.MONTH_OF_YEAR));
            dateList.add(date.get(ChronoField.DAY_OF_MONTH));
            return  dateList;
        } );

        System.out.println(hasanDate);

    }

    @Test
    void temporalAdjuster() {
        LocalDate localDate = LocalDate.now();

        LocalDate localDate1 = localDate.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate localDate2 = localDate.with(TemporalAdjusters.lastDayOfMonth());
        LocalDate localDate3 =  localDate.with(TemporalAdjusters.lastDayOfYear());
        LocalDate localDate4 =  localDate.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));


        System.out.println(localDate);
        System.out.println(localDate1);
        System.out.println(localDate2);
        System.out.println(localDate3);
        System.out.println(localDate4);
    }

    @Test
    void testTemporal() {
        Temporal temporal = LocalDateTime.now();

        List<Integer> currently = temporal.query(tempo -> {
            ArrayList<Integer> current = new ArrayList<>();
            current.add(tempo.get(ChronoField.YEAR));
            current.add(tempo.get(ChronoField.MONTH_OF_YEAR));
            current.add(tempo.get(ChronoField.DAY_OF_MONTH));
            current.add(tempo.get(ChronoField.HOUR_OF_DAY));
            current.add(tempo.get(ChronoField.MINUTE_OF_HOUR));
            return  current;
        });

        System.out.println(currently);

    }
}
