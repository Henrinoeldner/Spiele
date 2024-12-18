
    import java.util.Scanner;

    public class TicTacTo {
        private Scanner scanner;
        private int[] feld= new int[9];
        int gewaeltesfeld;
        boolean KreuzKreis=true;
        boolean gewonnen= false;
        int wiederhiolung=0;
        public void play() {

            scanner = new Scanner(System.in);
            wiederhiolung=0;
            gewonnen=false;
            feld= new int[9];
            while (wiederhiolung<9&&gewonnen==false){
                this.Creatfield();
                System.out.println("gib das feld an dass du befüllen möchtst:");
                gewaeltesfeld = scanner.nextInt()-1;
                feldwaehlen(gewaeltesfeld);
                this.gewonnen();
                if (gewonnen==true){
                    this.Creatfield();
                    System.out.println("Spiel wurde von "+this.WerHatGewonnen()+" gewonnen");
                }
                wiederhiolung++;
            }

        }

        private String WerHatGewonnen(){
            if (KreuzKreis) {
                return "Quadrat";
            }else{
                return "Strich";
            }
        }

        private void feldwaehlen(int pFeld){
            if (feld[pFeld]==0) {
                if (KreuzKreis) {
                    feld[pFeld] = 1;
                    KreuzKreis = !KreuzKreis;
                } else {
                    feld[pFeld] = 2;
                    KreuzKreis = !KreuzKreis;
                }
            }else{
                System.out.println("dein gewaaeltes feld wurde bereits von einen anderen Spieler besetzt. Bitte wähle ein neues Feld:");
                gewaeltesfeld = scanner.nextInt()-1;
                feldwaehlen(gewaeltesfeld);
            }

        }
        private void Creatfield(){
            System.out.println(" -----  -----  -----" );
            for (int i= 0;i<3;i++){
                for (int a=0;a<3;a++) {
                    if (feld[i * 3 + a] == 0) {
                        System.out.print("|     |");
                    } else if (feld[i * 3 + a] == 1) {
                        System.out.print("|   / |");
                    } else if (feld[i * 3 + a] == 2){
                        System.out.print("| --- |");
                    }
                }
                System.out.println();
                for (int a=0;a<3;a++) {
                    if (feld[i * 3 + a] == 0) {
                        System.out.print("|  " + (i * 3 + a+1) + "  |");
                    } else if (feld[i * 3 + a] == 1) {
                        System.out.print("|  /  |");
                    } else if (feld[i * 3 + a] == 2) {
                        System.out.print("| | | |");
                    }
                }
                System.out.println();
                for (int a=0;a<3;a++) {
                    if (feld[i * 3 + a] == 0) {
                        System.out.print("|     |");
                    } else if (feld[i * 3 + a] == 1) {
                        System.out.print("| /   |");
                    } else if (feld[i * 3 + a] == 2) {
                        System.out.print("| --- |");
                    }
                }
                System.out.println();
                System.out.println(" -----  -----  -----" );
            }

        }
        private void gewonnen() {
            if (feld[0] == feld[1] && feld[1] == feld[2]&&feld[0]!=0) {
                gewonnen=true;
            } else if (feld[3] == feld[4] && feld[4] == feld[5]&&feld[3]!=0) {
                gewonnen=true;
            } else if (feld[6] == feld[7] && feld[7] == feld[8]&&feld[8]!=0) {
                gewonnen=true;
            }else if(feld[0]==feld[4]&&feld[4]==feld[8]&&feld[8]!=0){
                gewonnen=true;
            }else if(feld[2]==feld[4]&&feld[4]==feld[6]&&feld[6]!=0){
                gewonnen=true;
            }else if(feld[0]==feld[3]&&feld[3]==feld[6]&&feld[6]!=0){
                gewonnen=true;
            }else if(feld[1]==feld[4]&&feld[4]==feld[7]&&feld[7]!=0){
                gewonnen=true;
            }else if(feld[2]==feld[5]&&feld[5]==feld[8]&&feld[8]!=0){
                gewonnen=true;
            }
        }
    }
