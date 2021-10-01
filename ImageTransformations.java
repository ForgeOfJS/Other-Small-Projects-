public class ImageTransformations {
    
    /**
     * Returns a grayscale version of originalImage as a 2D Pixel array..
     */
    public static Pixel[][] convertToGrayscale(Pixel[][] originalImage) {
        Pixel[][] grayImage = new Pixel[originalImage.length][originalImage[0].length];
        for (int row = 0; row < grayImage.length; row++) {
            for (int col = 0; col < grayImage[0].length; col++) {
                Pixel p = originalImage[row][col];
                int brightness = p.getBrightness();
                Pixel grayPixel = new Pixel(brightness, brightness, brightness);
                grayImage[row][col] = grayPixel;
            }
        }
        return grayImage;
    }
    
    /**
     * Returns a vertically-mirrored version of originalImage as a new 2D Pixel array.
     */
    public static Pixel[][] mirrorVertically(Pixel[][] originalImage) {
        Pixel[][] newImage = new Pixel[originalImage.length][originalImage[0].length];
        for (int row = 0; row < newImage.length; row++) {
            for (int col = 0, col2 = newImage[0].length-1; col < newImage[0].length; col++, col2--) {
                Pixel p = originalImage[row][col];
                int r = p.getR();
                int g = p.getG();
                int b = p.getB();
                Pixel newPixel = new Pixel(r, g, b);
                newImage[row][col2] = newPixel;
            }
        }
        return newImage;
    }
}
