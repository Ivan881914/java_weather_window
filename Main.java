import org.jsoup.*;
import java.io.IOException;
import javax.swing.*;

public class Main extends JFrame {
    public Main() {
        super("Погода на неделю Иркутск"); //Заголовок окна

        setBounds(100, 100, 200, 200); //Если не выставить


        //размер и положение
        //то окно будет мелкое и незаметное
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //это нужно для того чтобы при
        //закрытии окна закрывалась и программа,
        //иначе она останется висеть в процессах
    }
    public static void main(String[] args) throws IOException {
        var document = Jsoup.connect("https://yandex.ru/pogoda/irkutsk?lat=52.28959&lon=104.280608").get();
        //System.out.println(document);
        var dayElement = document.select("div.forecast-briefly__name");
        String dayElement_list = dayElement.text();
        //          System.out.println(dayElement_list);
        String[] day_words = dayElement_list.split("\\s");
        //System.out.println(Arrays.toString(day_words));
        System.out.println(day_words[0]);
        System.out.println(day_words[1]);
        System.out.println(day_words[2]);
        System.out.println(day_words[3]);

        var tempElement = document.select("div.forecast-briefly__temp_day");
        String tempElement_list = tempElement.text();
        //System.out.println(tempElement_list);
        String[] temp_words = tempElement_list.split("\\s");
        System.out.println(temp_words[0]);
        System.out.println(temp_words[1]);
        System.out.println(temp_words[2]);
        System.out.println(temp_words[3]);

        Main app = new Main(); //creating object for text field
        app.add(new JLabel( "<html><table border=\"1\">\n" +
                "    <thead>\n" +
                "    <tr>\n" +
                "        <th>"+day_words[0]+"</th>\n" +
                "        <th>"+day_words[1]+"</th>\n" +
                "        <th>"+day_words[2]+"</th>\n" +
                "        <th>"+day_words[3]+"</th>\n" +
                "    </tr>\n" +
                "    </thead>\n" +
                "    <tbody>\n" +
                "    <tr>\n" +
                "        <td>"+temp_words[0]+"</td>\n" +
                "        <td>"+temp_words[1]+"</td>\n" +
                "        <td>"+temp_words[2]+"</td>\n" +
                "        <td>"+temp_words[3]+"</td>\n" +

                "    </tr>\n" +
                "    </tbody>\n" +
                "</table></html>" ));
        app.setVisible(true);



    }
}