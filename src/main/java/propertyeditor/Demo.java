package propertyeditor;

import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: wanxiaotao
 * Date: 13-8-16
 * Time: обнГ4:42
 * To change this template use File | Settings | File Templates.
 */
public class Demo {
    @Test
    public void testPropertyEditor() {
        UserPropertyEditor editor = new UserPropertyEditor();

        editor.setAsText("wan,30");

        User user = (User) editor.getValue();
        System.out.println(user.getUserName() + "," + user.getAge());
    }
}
