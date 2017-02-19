package Mail;

/**
 * Thief – вор, который ворует самые ценные посылки и игнорирует все остальное. Вор принимает
 * в конструкторе переменную int – минимальную стоимость посылки, которую он будет воровать.
 * Также, в данном классе должен присутствовать метод getStolenValue, который возвращает суммарную
 * стоимость всех посылок, которые он своровал. Воровство происходит следующим образом: вместо посылки,
 * которая пришла вору, он отдает новую, такую же, только с нулевой ценностью и содержимым посылки
 * "stones instead of {content}".
 */
public class Thief implements MailService {
    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage)
        {
            MailPackage mailPackage = (MailPackage) mail;
            if (mailPackage.getContent().getPrice()  >= value) {
                this.stolen = this.stolen + mailPackage.getContent().getPrice();
                return  new MailPackage(mailPackage.getFrom(), mailPackage.getTo(),
                        new Package("stones instead of " + mailPackage.getContent().getContent() , 0));
            }
        }
        return mail;
    }

    private int value;
    private int stolen;
    public int getStolenValue () {
        return stolen;
    }

    public Thief (int value) {
        this.value = value;
        stolen = 0;
    }
}
