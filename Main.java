public class Main {
    public static void main(String[] args) {
        BaseConverter converter = new BaseConverter(25);
        System.out.println("Температура в градусах Цельсия: " + converter.convert("C"));
        System.out.println("Температура в градусах Кельвина: " + converter.convert("K"));
        System.out.println("Температура в градусах Фаренгейта: " + converter.convert("F"));
        converter = BaseConverter.create(77);
        System.out.println("Температура в градусах Цельсия: " + converter.convert("C"));
        System.out.println("Температура в градусах Кельвина: " + converter.convert("K"));
        System.out.println("Температура в градусах Фаренгейта: " + converter.convert("F"));
    }
}
