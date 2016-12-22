package Fach_6_FileIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileCopyFiles {
    public static void main(String[] args) throws IOException {

        // dieses klasse ab java8 benuetzte man zum kopieren!
        // Files.copy();
        //        "src/Fach_6_FileIO/myDirectory/songs.txt");
        //        "src/Fach_6_FileIO/myDirectory/songs-copy.txt");

        Path src = Paths.get("src/Fach_6_FileIO/myDirectory/songs.txt");
        Path dst = Paths.get("src/Fach_6_FileIO/myDirectory/songs-copy2.txt");
        Files.copy(src, dst, StandardCopyOption.REPLACE_EXISTING);
    }
}
