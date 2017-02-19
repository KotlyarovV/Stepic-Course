package Mail;

/**
 *  UntrustworthyMailWorker – класс, моделирующий ненадежного работника почты, который вместо того, чтобы
 *  передать почтовый объект непосредственно в сервис почты, последовательно передает этот объект набору
 *  третьих лиц, а затем, в конце концов, передает получившийся объект непосредственно экземпляру
 *  RealMailService. У UntrustworthyMailWorker должен быть конструктор от массива MailService ( результат
 *  вызова processMail первого элемента массива передается на вход processMail второго элемента, и т. д.)
 *  и метод getRealMailService, который возвращает ссылку на внутренний экземпляр RealMailService.
 */
public class UntrustworthyMailWorker implements MailService{
    public Sendable processMail (Sendable mail) {
        Sendable result = mail;
        for (int i = 0; i < mailServices.length ; i ++)
            result = mailServices[i].processMail(result);
        return realMailService.processMail(result);
    }

    private RealMailService realMailService;
    public RealMailService getRealMailService () {
        return realMailService;
    }
    private MailService[] mailServices;
    public UntrustworthyMailWorker (MailService[] mailServices) {
        this.realMailService = new RealMailService();
        this.mailServices = mailServices;
    }
}
