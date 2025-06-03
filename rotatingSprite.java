class rotatingSprite{
    public static char[][] pixels = new char[10][10];
    public static void main(String args[]) throws InterruptedException{
        int direction = 0;
        char[][] thing0 = {{'#', '.', '.', '.', '.'},
                           {'#', '#', '#', '.', '.'},
                           {'#', '#', '#', '#', '#'},
                           {'#', '#', '#', '.', '.'},
                           {'#', '.', '.', '.', '.'}};
        
        char[][] thing90 = {{'.', '.', '#', '.', '.'},
                            {'.', '.', '#', '.', '.'},
                            {'.', '#', '#', '#', '.'},
                            {'.', '#', '#', '#', '.'},
                            {'#', '#', '#', '#', '#'}};

        char[][] thing45 = {{'.', '.', '.', '#', '#'},
                            {'#', '#', '#', '#', '#'},
                            {'.', '#', '#', '#', '.'},
                            {'.', '.', '#', '#', '.'},
                            {'.', '.', '.', '#', '.'}};

        while (1==1){
            System.out.print("\033[H\033[2J");
            System.out.flush();

            for (int i = 0; i < 10; i++){
                for (int j = 0; j < 10; j++){
                    pixels[i][j] = ' ';
                }
            }
            
            direction += 45;
            if (direction == 360){
                direction = 0;
            }

            //draw sprite
            if (direction == 0){
                drawSprite(thing0, 4, -4, 5, 5, '.', false, false);
            }
            if (direction == 45){
                drawSprite(thing45, 4, -4, 5, 5, '.', false, true);
            }
            if (direction == 90){
                drawSprite(thing90, 4, -4, 5, 5, '.', false, true);
            }
            if (direction == 135){
                drawSprite(thing45, 4, -4, 5, 5, '.', true, true);
            }
            if (direction == 180){
                drawSprite(thing0, 4, -4, 5, 5, '.', true, false);
            }
            if (direction == 225){
                drawSprite(thing45, 4, -4, 5, 5, '.', true, false);
            }
            if (direction == 270){
                drawSprite(thing90, 4, -4, 5, 5, '.', false, false);
            }
            if (direction == 315){
                drawSprite(thing45, 4, -4, 5, 5, '.', false, false);
            }

            for (int i = 0; i < 10; i++){
                for (int j = 0; j < 10; j++){
                    System.out.print(pixels[i][j]);
                }
                System.out.println();
            }
            
            Thread.sleep(500);
        }
    }

    static void setPixel(int x, int y, char sym){
        pixels[Math.abs(y)][x] = sym;
    }
    static void drawSprite(char[][] sprite, int x, int y, int width, int height, char transperant, boolean hFlip, boolean vFlip){
        for (int i = y; i < y + height; i++){
            for (int j = x; j < x + width; j++){
                if (hFlip == false && vFlip == false){
                    if (sprite[i-y][j-x] != transperant){
                        setPixel(j, i, sprite[i-y][j-x]);
                    }
                }
                else if (hFlip == true && vFlip == false){
                    if (sprite[i-y][Math.abs(j-(x+(width-1)))] != transperant){
                        setPixel(j, i, sprite[i-y][Math.abs(j-(x+(width-1)))]);
                    }
                }
                else if (hFlip == false && vFlip == true){
                    if (sprite[Math.abs(i-(y+(height-1)))][j-x] != transperant){
                        setPixel(j, i, sprite[Math.abs(i-(y+(height-1)))][j-x]);
                    }
                }
                else if (hFlip == true && vFlip == true){
                    if (sprite[Math.abs(i-(y+(height-1)))][Math.abs(j-(x+(width-1)))] != transperant){
                        setPixel(j, i, sprite[Math.abs(i-(y+(height-1)))][Math.abs(j-(x+(width-1)))]);
                    }
                }
            }
        }
    }
}