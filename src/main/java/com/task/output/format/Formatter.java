package com.task.output.format;

import com.task.model.Manager;

public interface Formatter {
    String format();
    String formatErrors();
    String format(Manager manager);
}
