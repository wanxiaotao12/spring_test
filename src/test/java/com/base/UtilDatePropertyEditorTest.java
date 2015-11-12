package com.base;

import org.junit.Test;

import java.util.Date;

public class UtilDatePropertyEditorTest {
    @Test
public void testSetAsText() throws Exception {
    UtilDatePropertyEditor editor = new UtilDatePropertyEditor();
    editor.setAsText("2014-8-8 20:19:00");
    Date date = (Date) editor.getValue();
    System.out.println(date);
}
}
