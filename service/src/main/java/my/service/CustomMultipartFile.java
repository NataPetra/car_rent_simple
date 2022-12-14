package my.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

public class CustomMultipartFile implements MultipartFile {

    private final byte[] fileContent;

    private final String fileName;

    private String contentType;

    private final File file;

    private final String destPath = System.getProperty("java.io.tmpdir");

    private FileOutputStream fileOutputStream;

    public CustomMultipartFile(byte[] fileData, String name) {
        this.fileContent = fileData;
        this.fileName = name;
        file = new File(destPath + fileName);

    }

    @Override
    public void transferTo(File dest) throws IOException, IllegalStateException {
        fileOutputStream = new FileOutputStream(dest);
        fileOutputStream.write(fileContent);
    }

    public void clearOutStreams() throws IOException {
        if (null != fileOutputStream) {
            fileOutputStream.flush();
            fileOutputStream.close();
            file.deleteOnExit();
        }
    }

    @Override
    public String getName() {
        return fileName;
    }

    @Override
    public String getOriginalFilename() {
        return file.getName();
    }

    @Override
    public String getContentType() {
        return "image/jpeg";
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public long getSize() {
        return fileContent.length;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return fileContent;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(fileContent);
    }


}
