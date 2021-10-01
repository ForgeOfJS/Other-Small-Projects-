public class GreenScreen {

    private Pixel[][] foreground;
    private int[][] mask;

    public GreenScreen(Pixel[][] foreground) {
        this.foreground = foreground;
        this.mask = createMask();
    }
    
    private int[][] createMask() {
        int[][] mask = new int[foreground.length][foreground[0].length];
        createMaskHelper(mask, foreground[0][0], 0, 0);
        return mask;
    }
    
    /**
    * A method to help debug mask creation. Returns a *new* image with black-and-white Pixels
    * based on the mask values.
    */
    public Pixel[][] getMaskAsImage() {
        // TODO: Write this method.
        Pixel[][] tempImage = new Pixel[mask.length][mask[0].length];
        for (int row = 0; row < mask.length; row++) {
            for (int col = 0; col < mask[0].length; col++) {
                if (mask[row][col] == 1) {
                    tempImage[row][col] = new Pixel(255, 255, 255);
                }
                else {
                    tempImage[row][col] = new Pixel(0, 0, 0);
                }
            }
        }
        return tempImage;
    }

    // A recursive helper method for createMask. This method does all of the work.
    private void createMaskHelper(int[][] mask, Pixel reference, int row, int col) {
        // TODO: Write this method.
        if (mask[row][col] != 0) {
            return;
        }
        if (foreground[row][col].distanceTo(reference) < 300) {
            mask[row][col] = 1;
        }
        else {
            mask[row][col] = -1;
            return;
        }
        //recursing to top pixel
        if (row < foreground.length - 1) {
            createMaskHelper(mask, foreground[row][col], row + 1, col);
        }
        //recursing to right pixel
        if (col < foreground[0].length - 1) {
            createMaskHelper(mask, foreground[row][col], row, col + 1);
        }
        //recursing to bottom pixel
        if (row > 0) {
            createMaskHelper(mask, foreground[row][col], row - 1, col);
        }
        //recursing to left pixel
        if (col > 0) {
            createMaskHelper(mask, foreground[row][col], row, col - 1);
        }
        
        
    }

    /**
    * Creates a *new* image, replacing the background of the foreground image with the input image.
    * The mask must have already been computed to use this method.
    */
    private Pixel[][] replaceBackground(Pixel[][] background) {
        // TODO: Write this method.
        Pixel[][] newImage = new Pixel[foreground.length][foreground[0].length];
        for (int row = 0; row < foreground.length; row ++) {
            for (int col = 0; col < foreground[0].length; col ++) {
                if (mask[row][col] == 1) {
                    newImage[row][col] = background[row][col];
                }
                else {
                    newImage[row][col] = foreground[row][col];
                }   
                    
            }
        }
        return newImage;
    }

    public static void main(String[] args) {
      // Uncomment this section when you have completed the createMask/createMaskHelper methods.  
      Picture fg = new Picture("utep_cs_building_small.jpeg");
      GreenScreen greenScreen = new GreenScreen(fg.getImageMatrix());
      
      // Uncomment this section when you have completed the getMaskAsImage method.
      Pixel[][] maskImage = greenScreen.getMaskAsImage();
      Picture maskPicture = new Picture(maskImage);
      maskPicture.save("mask_utep2.png");
      
      // Uncomment this section when you have completed the replaceBackground method.
      Picture bg1 = new Picture("starrynight.jpg");
      Pixel[][] starryNightUtep = greenScreen.replaceBackground(bg1.getImageMatrix());
      Picture result1 = new Picture(starryNightUtep);
      result1.save("starrynight_utep.png");
      
      Picture bg2 = new Picture("thisisfine.jpeg");
      Pixel[][] thisIsFineUtep = greenScreen.replaceBackground(bg2.getImageMatrix());
      Picture result2 = new Picture(thisIsFineUtep);
      result2.save("thisisfine_utep.png");
    }
}
