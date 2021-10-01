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
    public static Pixel[][] rotateClockwise(Pixel[][] originalImage) {
        Pixel[][] newImage = new Pixel[originalImage[0].length][originalImage.length];
        for(int row = 0; row < newImage[0].length; row++) {
            for (int col = 0; col < newImage.length; col++, ) {
                newImage[row][col] = originalImage[col][row];
            }    
        }
        return newImage;
    }
    
    public static void main(String[] args) {
        // Read miners.png into a 2D Pixel array.
        Picture picture = new Picture("miners.png");
        Pixel[][] originalImage = picture.getImageMatrix();
        Pixel[][] newImage = convertToGrayscale(originalImage);
        newImage = mirrorVertically(newImage);
        newImage = rotateClockwise(newImage);
        // TODO: Fix the image by using your convertToGrayscale, mirrorVertically, and
        // rotateClcokwise methods.

        // TODO: To save your image, uncomment the lines below and add your Pixel array as the
        // argument to the Picture constructor.
        Picture result = new Picture(newImage);
        result.save("miners_fixed.png");
    }
}
