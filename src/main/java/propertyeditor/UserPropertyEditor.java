package propertyeditor;

import java.beans.PropertyEditorSupport;

/**
 * Created by IntelliJ IDEA.
 * User: wanxiaotao
 * Date: 13-8-16
 * Time: обнГ4:39
 * To change this template use File | Settings | File Templates.
 */
public class UserPropertyEditor extends PropertyEditorSupport{
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String[] args = text.split(",");
        User user = new User();
        user.setUserName(args[0]);
        user.setAge(Integer.parseInt(args[1]));

        setValue(user);
    }
}
