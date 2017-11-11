package calc;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class JMXAgent {
    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException,
            InstanceAlreadyExistsException, MBeanRegistrationException {

        //сервер для регистрации MBean
        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
        //сама моделька нашего калькулятора
        CalculatorMBean calculatorMBean = new CalculatorModel(3, 2);
        //определение имени для нашего мбина на уровне JMX менеджера(catalog,
        //folder, format - standard; %catalog%:name=%folder%)
        ObjectName objectName = new ObjectName("calc-jmx-test-project:name=petya");
        //создаем стандартный mBean
        StandardMBean standardMBean = new StandardMBean(calculatorMBean, CalculatorMBean.class);
        //регистрация mBean
        platformMBeanServer.registerMBean(standardMBean, objectName);
        //бесконечный цыкл для зависания программы
        for (; ;){

        }
    }
}
