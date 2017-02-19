package Mail;
import java.util.logging.*;
/**
 *  Spy – шпион, который логгирует о всей почтовой переписке, которая проходит через его руки. Объект
 *  конструируется от экземпляра Logger, с помощью которого шпион будет сообщать о всех действиях.
 *  Он следит только за объектами класса MailMessage и пишет в логгер следующие сообщения (в выражениях
 *  нужно заменить части в фигурных скобках на значения полей почты):
  Если в качестве отправителя или получателя указан "Austin Powers", то нужно написать в лог
 сообщение с уровнем WARN: Detected target mail correspondence: from {from} to {to} "{message}"
  Иначе, необходимо написать в лог сообщение с уровнем INFO: Usual correspondence: from {from} to {to}
 */
public class Spy implements MailService{
    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailMessage) {
            MailMessage message = (MailMessage) mail;
            if (message.getFrom().equals("Austin Powers") || message.getTo().equals("Austin Powers"))
                logger.warning("Detected target mail correspondence: from "+ message.getFrom() +
                        " to "+message.getTo()+" \""+ message.getMessage().toString() + "\"");
            else
                logger.info("Usual correspondence: from "+message.getFrom()+ " to "+message.getTo());
        }
        return mail;
    }
    private Logger logger;
    public Spy (Logger logger)
    {
        this.logger = logger;
    }
}
