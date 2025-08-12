package com.task.config;

import com.task.model.Manager;
import com.task.output.printer.Printer;
import com.task.output.printer.impl.ConsolePrinter;
import com.task.repository.SimpleRepository;
import com.task.repository.impl.EmployeeListRepository;
import com.task.repository.impl.ListRepository;
import lombok.Getter;
import lombok.Setter;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

@Getter
public class MainData {
    private static final MainData INSTANCE = new MainData();

    private final DecimalFormat decimalFormat = new DecimalFormat("0.00", new DecimalFormatSymbols(Locale.US));
    private final EmployeeListRepository employeeRepository = new EmployeeListRepository();
    private final SimpleRepository<Manager> managerRepository = new ListRepository<>();
    private final SimpleRepository<String> errorsRepository = new ListRepository<>();

    @Setter
    private Printer outputStatSource = new ConsolePrinter();

    public MainData() {
        decimalFormat.setRoundingMode(RoundingMode.CEILING);
    }

    public static MainData getInstance() {
        return INSTANCE;
    }
}
