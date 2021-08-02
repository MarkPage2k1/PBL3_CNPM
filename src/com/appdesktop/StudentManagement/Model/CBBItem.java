package com.appdesktop.StudentManagement.Model;

public class CBBItem {
    public String Value;
    public String Text;

    public CBBItem(String Value, String Text) {
        this.Value = Value;
        this.Text = Text;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String Value) {
        this.Value = Value;
    }

    public String getText() {
        return Text;
    }

    public void setText(String Text) {
        this.Text = Text; 
    }
    
    @Override
    public String toString() {
        return this.Text;
    }
}
