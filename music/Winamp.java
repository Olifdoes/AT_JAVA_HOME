package music;

public class Winamp {
    static void main() {
        // Создаём плейлист
        Playlist playlist = new Playlist("Мои любимые треки");

        // Вызываем все методы
        playlist.addSong("Bohemian Rhapsody - Queen");
        playlist.addSong("Smells Like Teen Spirit - Nirvana");
        playlist.addSong("Hotel California - Eagles");
        playlist.addSong("Imagine - John Lennon");

        System.out.println("\n--- Тестируем получение ---");
        playlist.getSong(2);

        System.out.println("\n--- Тестируем обновление ---");
        playlist.updateSong(0, "Stairway to Heaven - Led Zeppelin");

        System.out.println("\n--- Тестируем удаление ---");
        playlist.removeSong(3);

        // Выводим весь плейлист
        System.out.println("\n" + playlist);
    }
}