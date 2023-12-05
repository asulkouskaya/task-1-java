import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.*;

public class BaseConverterTest {
    @Test
    public void testToKelvin() {
        BaseConverter converter = new BaseConverter(25);
        assertEquals(298.15, converter.toKelvin(), 0.01);
    }
    @Test
    public void testToFahrenheit() {
        BaseConverter converter = new BaseConverter(25);
        assertEquals(77, converter.toFahrenheit(), 0.01);
    }

    @Test
    public void testGetCelsius() {
        BaseConverter converter = new BaseConverter(25);
        assertEquals(25, converter.getCelsius(), 0.01);
    }

    @Test
    public void testConvert() {
        BaseConverter converter = new BaseConverter(25);
        assertEquals("298,15 K", converter.convert("K"));
        assertEquals("77,00 °F", converter.convert("F"));
        assertEquals("25,00 °C", converter.convert("C"));
        assertEquals("Invalid unit", converter.convert("R"));
    }

    @Test
    public void testCreate() {
        Locale.setDefault(Locale.US);
        BaseConverter converter = BaseConverter.create(77);
        assertEquals(25, converter.getCelsius(), 0.01);
        Locale.setDefault(new Locale("ru", "RU"));
        converter = BaseConverter.create(25);
        assertEquals(25, converter.getCelsius(), 0.01);
    }
}
