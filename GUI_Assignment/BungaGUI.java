import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BungaGUI extends JFrame {

    // Atomic Component
    private JLabel judul;
    private JLabel deskripsi;
    private JComboBox<String> pilihBunga;
    private JButton tombolTampil;
    private JButton tombolReset;
    private GambarBunga gambar;

    // Data bunga
    private String[] nama = {"Mawar", "Melati", "Matahari", "Anggrek"};
    private Color[] warnaKelopak = {
        Color.RED, Color.WHITE, Color.YELLOW, new Color(186, 85, 211)
    };
    private Color[] warnaPusat = {
        Color.ORANGE, Color.ORANGE, new Color(120, 70, 20), Color.YELLOW
    };
    private String[] info = {
        "Mawar: bunga berduri, simbol cinta.",
        "Melati: bunga putih harum, bunga nasional Indonesia.",
        "Matahari: bunga kuning besar yang selalu menghadap matahari.",
        "Anggrek: bunga cantik dengan banyak jenis dan warna."
    };

    public BungaGUI() {
        // TOP LEVEL CONTAINER: JFrame
        setTitle("Program Bunga");
        setSize(450, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // LAYOUT 1: BorderLayout
        setLayout(new BorderLayout());

        // Buat komponen
        judul = new JLabel("Klik tulisan ini untuk ganti warna", JLabel.CENTER);
        deskripsi = new JLabel("Pilih bunga lalu klik Tampilkan", JLabel.CENTER);
        pilihBunga = new JComboBox<String>(nama);
        tombolTampil = new JButton("Tampilkan");
        tombolReset = new JButton("Reset");
        gambar = new GambarBunga();

        // INTERMEDIATE CONTAINER: JPanel (atas)
        JPanel panelAtas = new JPanel();
        // LAYOUT 2: FlowLayout
        panelAtas.setLayout(new FlowLayout());
        panelAtas.add(new JLabel("Bunga:"));
        panelAtas.add(pilihBunga);
        panelAtas.add(tombolTampil);
        panelAtas.add(tombolReset);

        // INTERMEDIATE CONTAINER: JPanel (bawah)
        JPanel panelBawah = new JPanel();
        // LAYOUT 3: GridLayout
        panelBawah.setLayout(new GridLayout(2, 1));
        panelBawah.add(deskripsi);
        panelBawah.add(judul);

        add(panelAtas, BorderLayout.NORTH);
        add(gambar, BorderLayout.CENTER);
        add(panelBawah, BorderLayout.SOUTH);

        // EVENT LISTENER 1: ActionListener (Interface)
        tombolTampil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = pilihBunga.getSelectedIndex();
                gambar.setWarna(warnaKelopak[i], warnaPusat[i]);
                deskripsi.setText(info[i]);
            }
        });

        tombolReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gambar.setWarna(Color.PINK, Color.ORANGE);
                deskripsi.setText("Pilih bunga lalu klik Tampilkan");
                pilihBunga.setSelectedIndex(0);
            }
        });

        // EVENT LISTENER 2: MouseAdapter (Adapter Class)
        judul.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                judul.setForeground(Color.MAGENTA);
            }
        });
    }

    // Panel khusus untuk menggambar bunga
    class GambarBunga extends JPanel {
        private Color kelopak = Color.PINK;
        private Color pusat = Color.ORANGE;

        public GambarBunga() {
            setBackground(new Color(200, 230, 255));
        }

        public void setWarna(Color k, Color p) {
            kelopak = k;
            pusat = p;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            int cx = getWidth() / 2;
            int cy = getHeight() / 2 - 30;

            // Batang dan daun
            g2.setColor(new Color(34, 139, 34));
            g2.setStroke(new BasicStroke(8));
            g2.drawLine(cx, cy, cx, getHeight() - 10);
            g2.fillOval(cx, cy + 90, 60, 25);
            g2.fillOval(cx - 60, cy + 130, 60, 25);

            // Kelopak (8 buah, diputar tiap 45 derajat)
            for (int i = 0; i < 8; i++) {
                Graphics2D gp = (Graphics2D) g2.create();
                gp.rotate(Math.toRadians(i * 45), cx, cy);
                gp.setColor(kelopak);
                gp.fillOval(cx - 15, cy - 75, 30, 65);
                gp.setColor(Color.DARK_GRAY);
                gp.setStroke(new BasicStroke(1));
                gp.drawOval(cx - 15, cy - 75, 30, 65);
                gp.dispose();
            }

            // Bagian tengah bunga
            g2.setColor(pusat);
            g2.fillOval(cx - 25, cy - 25, 50, 50);
        }
    }

    public static void main(String[] args) {
        BungaGUI gui = new BungaGUI();
        gui.setVisible(true);
    }
}
