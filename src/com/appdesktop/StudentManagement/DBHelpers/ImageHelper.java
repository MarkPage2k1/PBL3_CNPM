package com.appdesktop.StudentManagement.DBHelpers;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageHelper {
    public static Image resize(Image originalImage, int targetWith, int targetHeight ) {
        Image resultingImage = originalImage.getScaledInstance(targetWith, targetHeight, Image.SCALE_SMOOTH);
        return resultingImage;
    }
    
    public static byte[] toBytoArray(Image img, String type) throws IOException{
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bimage.createGraphics();
        g.drawImage(img, 0, 0, null);
        g.dispose();
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bimage, type, baos);
        byte[] iamageInByte = baos.toByteArray();
        
        return iamageInByte;
    }
    
    public static Image creImageFromByteArray(byte[] data, String type) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        BufferedImage bImage2 = ImageIO.read(bis);
        
        Image img = bImage2.getScaledInstance(bImage2.getWidth(), bImage2.getHeight(), Image.SCALE_SMOOTH);
        return img;
    }
}
