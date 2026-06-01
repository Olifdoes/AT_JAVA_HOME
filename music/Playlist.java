package music;

import java.util.ArrayList;

public class Playlist {

    private final String name;                    // Название плейлиста
    private final ArrayList<String> songs;        // Список песен

    // Конструктор
    public Playlist(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }

    // 1. Добавление песни
    public void addSong(String song) {
        songs.add(song);
        System.out.println("✅ Добавлена песня: \"" + song + "\"");
    }

    // 2. Удаление песни по индексу
    public void removeSong(int index) {
        if (index >= 0 && index < songs.size()) {
            String removedSong = songs.remove(index);
            System.out.println("🗑 Удалена песня по индексу " + index + ": \"" + removedSong + "\"");
        } else {
            System.out.println("❌ Ошибка: Неверный индекс для удаления!");
        }
    }

    // 3. Обновление песни по индексу
    public void updateSong(int index, String newSong) {
        if (index >= 0 && index < songs.size()) {
            String oldSong = songs.set(index, newSong);
            System.out.println("✏ Обновлена песня по индексу " + index +
                    ": \"" + oldSong + "\" → \"" + newSong + "\"");
        } else {
            System.out.println("❌ Ошибка: Неверный индекс для обновления!");
        }
    }

    // 4. Получение песни по индексу
    public String getSong(int index) {
        if (index >= 0 && index < songs.size()) {
            String song = songs.get(index);
            System.out.println("📌 Получена песня по индексу " + index + ": \"" + song + "\"");
            return song;
        } else {
            System.out.println("❌ Ошибка: Неверный индекс!");
            return null;
        }
    }

    // Красивый вывод объекта в консоль
    @Override
    public String toString() {
        return "🎵 Плейлист: \"" + name + "\"\n" +
                "   Количество песен: " + songs.size() + "\n" +
                "   Список песен: " + songs;
    }
}