package Mail;

import java.util.Set;

/**
 * Inspector – Инспектор, который следит за запрещенными и украденными посылками и бьет
 * тревогу в виде исключения, если была обнаружена подобная посылка. Если он заметил запрещенную посылку
 * с одним из запрещенных содержимым ("weapons" и "banned substance"), то он бросает IllegalPackageException.
 * Если он находит посылку, состоящую из камней (содержит слово "stones"), то тревога прозвучит в
 * виде StolenPackageException. Оба исключения вы должны объявить самостоятельно в виде непроверяемых
 * исключений.
 */
public class Inspector implements MailService {

    private String WEAPONS = "weapons";
    private String BANNED = "banned substance";
    private String STONES = "stones";

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            MailPackage mailPackage = (MailPackage) mail;
            Package pack = mailPackage.getContent();
            if (pack.getContent().equals(WEAPONS))
                throw new IllegalPackageException();
            if (mailPackage.getContent().getContent().equals(BANNED))
                throw new IllegalPackageException();
            if (mailPackage.getContent().getContent().contains(STONES))
                throw new StolenPackageException();
        }
        return mail;
    }
}
