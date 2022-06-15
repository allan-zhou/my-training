package me.example.training.designpattern.builder;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhoujialiang9
 * @date 2022/6/13 5:35 PM
 **/
@Setter
@Getter
public class Computer {
    /**
     * 必选
     */
    private String cpu;
    /**
     * 必选
     */
    private String ram;
    /**
     * 可选：显示器
     */
    private String display;
    /**
     * 可选：键盘
     */
    private String keyboard;
    /**
     * 可选：鼠标
     */
    private String mouse;

    Computer(String cpu, String ram, String display, String keyboard, String mouse) {
        this.cpu = cpu;
        this.ram = ram;
        this.display = display;
        this.keyboard = keyboard;
        this.mouse = mouse;
    }

    public static ComputerBuilder builder() {
        return new ComputerBuilder();
    }


    public static class ComputerBuilder {
        private String cpu;
        private String ram;
        private String display;
        private String keyboard;
        private String mouse;

        ComputerBuilder() {
        }

        public ComputerBuilder cpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public ComputerBuilder ram(String ram) {
            this.ram = ram;
            return this;
        }

        public ComputerBuilder display(String display) {
            this.display = display;
            return this;
        }

        public ComputerBuilder keyboard(String keyboard) {
            this.keyboard = keyboard;
            return this;
        }

        public ComputerBuilder mouse(String mouse) {
            this.mouse = mouse;
            return this;
        }

        public Computer build() {
            return new Computer(cpu, ram, display, keyboard, mouse);
        }

        public String toString() {
            return "Computer.ComputerBuilder(cpu=" + this.cpu + ", ram=" + this.ram + ", display=" + this.display + ", keyboard=" + this.keyboard + ", mouse=" + this.mouse + ")";
        }
    }
}
