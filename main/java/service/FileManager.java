package service;

import model.*;
import java.io.*;
import java.util.*;

public class FileManager {
    private final String filename;

    public FileManager(String filename) {
        this.filename = filename;
    }

    public FileManager() {
        this("appliances.txt");
    }

    public void save(List<Appliance> appliances) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (Appliance a : appliances) {
                pw.println(serialize(a));
            }
            System.out.println("Дані збережено у файл: " + filename);
        } catch (IOException e) {
            System.out.println("Помилка збереження: " + e.getMessage());
        }
    }

    public List<Appliance> load() {
        List<Appliance> list = new ArrayList<>();
        File f = new File(filename);
        if (!f.exists()) {
            System.out.println("Файл не знайдено: " + filename + " — повернуто порожній список.");
            return list;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int ln = 0;
            while ((line = br.readLine()) != null) {
                ln++;
                line = line.trim();
                if (line.isEmpty()) continue;
                Appliance a = deserialize(line);
                if (a != null) list.add(a);
                else System.out.println("Пропущено рядок " + ln + " (неправильний формат): " + line);
            }
            System.out.println("Дані завантажено з файлу: " + filename);
        } catch (IOException e) {
            System.out.println("Помилка завантаження: " + e.getMessage());
        }
        return list;
    }

    private String serialize(Appliance a) {
        String type;
        String extra = "";
        if (a instanceof KitchenAppliance ka) {
            type = "Kitchen";
            extra = String.valueOf(ka.getVolume());
        } else if (a instanceof CleaningAppliance ca) {
            type = "Cleaning";
            extra = String.valueOf(ca.getArea());
        } else if (a instanceof EntertainmentAppliance ea) {
            type = "Entertainment";
            extra = String.valueOf(ea.getScreenSize());
        } else {
            type = "Unknown";
        }
        return String.join(";", type, escape(a.getName()), String.valueOf(a.getPower()), String.valueOf(a.isOn()), extra);
    }

    private Appliance deserialize(String line) {
        String[] parts = line.split(";", -1);
        if (parts.length < 5) return null;
        String type = parts[0];
        String name = unescape(parts[1]);
        double power;
        boolean isOn;
        double extra;
        try {
            power = Double.parseDouble(parts[2]);
            isOn = Boolean.parseBoolean(parts[3]);
            extra = Double.parseDouble(parts[4]);
        } catch (NumberFormatException e) {
            return null;
        }

        Appliance a = switch (type) {
            case "Kitchen" -> new KitchenAppliance(name, power, extra);
            case "Cleaning" -> new CleaningAppliance(name, power, extra);
            case "Entertainment" -> new EntertainmentAppliance(name, power, extra);
            default -> null;
        };
        if (a != null && isOn) a.turnOn();
        return a;
    }

    private String escape(String s) {
        return s.replace(";", "\\;");
    }

    private String unescape(String s) {
        return s.replace("\\;", ";");
    }
}