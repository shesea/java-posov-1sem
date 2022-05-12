module ru.spbu.arts.java.javafx {
    requires javafx.base; // другие модули, которые используем
    requires javafx.graphics;
    requires javafx.controls;

    //разрешаем библиотеке javafx исследовать содержимое нашего пакета с кодом
    opens ru.spbu.arts.java.javafx.button;
    opens ru.spbu.arts.java.javafx.messenger;
    opens ru.spbu.arts.java.javafx.circle;
    opens ru.spbu.arts.java.javafx.images;
}