package ExeptionsRobot;

/**
 * Created by vitaly on 04.02.17.
 * Попытка отдать команду роботу считается успешной, если удалось установить соединение и
 * выполнить метод RobotConnection.moveRobotTo() без исключений. Ошибка закрытия соединения не важна
 * и должна игнорироваться.
 Если первая попытка подключиться и отдать команду оказалась неуспешной, то закрываем соединение и
 выполняем вторую попытку. Если вторая тоже не удалась, то выполняется третья. После третьей неудачи метод
 должен бросить исключение RobotConnectionException.
 Метод отвечает за открытие и закрытие соединения. Если соединение удалось установить, то оно обязательно
 должно быть закрыто несмотря на возможные исключения, случившиеся в дальнейшем во время работы метода.
 Если во время работы метода случилось исключение любого типа, отличного от RobotConnectionException,
 метод должен завершиться и выбросить это исключение, не выполняя повторных попыток пообщаться с роботом.
 Единственное,
 что метод должен сделать перед выбросом этого исключения — закрыть открытое соединение RobotConnection.
 */
public class Main {
    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        // your implementation here
        int i = 0;
        boolean s = true;
        while (s)
        {
            try(RobotConnection con = robotConnectionManager.getConnection()) {
                con.moveRobotTo(toX,toY);
                s = false;
            }
            catch (RobotConnectionException a) {
                if ((i = i + 1) == 3) throw a;
            }
            catch (Throwable e) {
                throw e;
            }
        }
    }
}