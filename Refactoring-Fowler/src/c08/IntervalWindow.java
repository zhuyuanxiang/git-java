package c08;

import java.awt.Frame;
import java.awt.HeadlessException;
import java.util.Observable;
import java.util.Observer;
import java.awt.TextField;

public class IntervalWindow extends Frame implements Observer {
  TextField _startField;
  TextField _endField;
  TextField _lengthField;
  Interval _subject;

  class SymFocus extends java.awt.event.FocusAdapter {
    @Override
    public void focusLost(java.awt.event.FocusEvent event) {
      Object object = event.getSource();
      if (object == _startField) {
        StartField_FocusLost(event);
      } else if (object == _endField) {
        EndField_FocusLost(event);
      } else if (object == _lengthField) {
        LengthField_FocusLost(event);
      }
    }

    void StartField_FocusLost(java.awt.event.FocusEvent event) {
      if (isNotInteger(_subject.getStart())) {
        _subject.setStart("0");
      }
      _subject.calculateLength();
    }

    void EndField_FocusLost(java.awt.event.FocusEvent event) {
      if (isNotInteger(_subject.getEnd())) {
        _subject.setEnd("0");
      }
      _subject.calculateLength();
    }

    void LengthField_FocusLost(java.awt.event.FocusEvent event) {
      if (isNotInteger(_subject.getLength())) {
        _subject.setLength("0");
      }
      _subject.calculateEnd();
    }

  }

  public IntervalWindow() throws HeadlessException {
    _subject = new Interval();
    _subject.addObserver(this);
    update(_subject, null);
  }

  boolean isNotInteger(String text) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void update(Observable o, Object arg) {
    _endField.setText(_subject.getEnd());
    _startField.setText(_subject.getStart());
    _lengthField.setText(_subject.getLength());
  }
}
