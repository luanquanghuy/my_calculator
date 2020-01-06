package vn.huy.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtSoHang, txtphepToan, txtKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
    }

    public void xuLy(View view) {
        switch (view.getId()){
            case R.id.so0:
            case R.id.so1:
            case R.id.so2:
            case R.id.so3:
            case R.id.so4:
            case R.id.so5:
            case R.id.so6:
            case R.id.so7:
            case R.id.so8:
            case R.id.so9:
                txtSoHang.setText(txtSoHang.getText().toString().concat(((TextView) findViewById(view.getId())).getText().toString()));
                break;
            case R.id.dauCong:
                if(!txtSoHang.getText().toString().isEmpty()) {
                    xulyBang();
                }
                txtphepToan.setText("+");
                txtSoHang.setText("");
                break;
            case R.id.dauTru:
                if(!txtSoHang.getText().toString().isEmpty()) {
                    xulyBang();
                }
                txtphepToan.setText("-");
                txtSoHang.setText("");
                break;
            case R.id.dauNhan:
                if(!txtSoHang.getText().toString().isEmpty()) {
                    xulyBang();
                }
                txtphepToan.setText("x");
                txtSoHang.setText("");
                break;
            case R.id.dauChia:
                if(!txtSoHang.getText().toString().isEmpty()) {
                    xulyBang();
                }
                txtphepToan.setText(":");
                txtSoHang.setText("");
                break;
            case R.id.dauBang:
                if(!txtSoHang.getText().toString().isEmpty()) {
                    xulyBang();
                    txtphepToan.setText("");
                    txtSoHang.setText("");
                }
        }
    }

    private void anhXa(){
        txtSoHang = findViewById(R.id.soHang);
        txtphepToan = findViewById(R.id.phepToan);
        txtKetQua = findViewById(R.id.ketQua);
    }

    private void xulyBang(){
        if(txtphepToan.getText().toString().isEmpty()){
            txtKetQua.setText(txtSoHang.getText().toString());
        }else {
            switch (txtphepToan.getText().toString().charAt(0)){
                case '+':
                    txtKetQua.setText(String.valueOf(Double.parseDouble(txtKetQua.getText().toString()) + Double.parseDouble(txtSoHang.getText().toString())));
                    break;
                case '-':
                    txtKetQua.setText(String.valueOf(Double.parseDouble(txtKetQua.getText().toString()) - Double.parseDouble(txtSoHang.getText().toString())));
                    break;
                case 'x':
                    txtKetQua.setText(String.valueOf(Double.parseDouble(txtKetQua.getText().toString()) * Double.parseDouble(txtSoHang.getText().toString())));
                    break;
                case ':':
                    txtKetQua.setText(String.valueOf(Double.parseDouble(txtKetQua.getText().toString()) / Double.parseDouble(txtSoHang.getText().toString())));
            }
        }
    }
}
