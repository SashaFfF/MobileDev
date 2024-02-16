package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt0, bt_pi, bt_dot,
            bt_equal, bt_plus, bt_min, bt_mul, bt_div, bt_sqrt, bt_square,
            bt_inv, bt_sin, bt_cos, bt_tg, bt_ctg, bt_log, btb1, btb2, bt_ac, bt_c;

    TextView tv_main, tv_sec;
    String pi = "3.141592";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);
        bt5 = findViewById(R.id.bt5);
        bt6 = findViewById(R.id.bt6);
        bt7 = findViewById(R.id.bt7);
        bt8 = findViewById(R.id.bt8);
        bt9 = findViewById(R.id.bt9);
        bt0 = findViewById(R.id.bt0);

        bt_pi = findViewById(R.id.bt_pi);
        bt_dot = findViewById(R.id.bt_dot);
        bt_equal = findViewById(R.id.bt_equal);
        bt_plus = findViewById(R.id.bt_plus);
        bt_min = findViewById(R.id.bt_min);
        bt_mul = findViewById(R.id.bt_mul);
        bt_div = findViewById(R.id.bt_div);
        bt_sqrt = findViewById(R.id.bt_sqrt);
        bt_square = findViewById(R.id.bt_square);

        bt_inv = findViewById(R.id.bt_inv);
        bt_sin = findViewById(R.id.bt_sin);
        bt_cos = findViewById(R.id.bt_cos);
        bt_tg = findViewById(R.id.bt_tg);
        bt_ctg = findViewById(R.id.bt_ctg);
        bt_log = findViewById(R.id.bt_log);
        btb1 = findViewById(R.id.bt_bracket1);
        btb2= findViewById(R.id.bt_bracket2);
        bt_ac= findViewById(R.id.bt_ac);
        bt_c = findViewById(R.id.bt_c);

        tv_main = findViewById(R.id.tv_main);
        tv_sec = findViewById(R.id.tv_sec);

        //onclick listeners
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_main.setText(tv_main.getText()+"1");
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_main.setText(tv_main.getText()+"2");
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_main.setText(tv_main.getText()+"3");
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_main.setText(tv_main.getText()+"4");
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_main.setText(tv_main.getText()+"5");
            }
        });
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_main.setText(tv_main.getText()+"6");
            }
        });
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_main.setText(tv_main.getText()+"7");
            }
        });
        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_main.setText(tv_main.getText()+"8");
            }
        });
        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_main.setText(tv_main.getText()+"9");
            }
        });
        bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_main.setText(tv_main.getText()+"0");
            }
        });
        bt_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String expression = tv_main.getText().toString();

                // Разделяем выражение на отдельные числа и операторы
                String[] tokens = expression.split("(?<=[-+*/^()])|(?=[-+*/^()])");

                // Проверяем последний токен на наличие десятичной точки
                String lastToken = tokens[tokens.length - 1];
                boolean isAfterBracket = lastToken.equals(")");

                if (!lastToken.contains(".") && !isAfterBracket) {
                    //После триг. функций хочу, чтобы писалась не просто точка, а "0."
                    if (lastToken.matches("sin|cos|tg|ctg|ln")) {
                        tv_main.setText(expression + "0.");
                    } else {
                        tv_main.setText(expression + ".");
                    }
                }
            }
        });
        bt_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_main.setText("");
                tv_sec.setText("");
            }
        });
        bt_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = tv_main.getText().toString();
                if(!val.isEmpty()){
                    val = val.substring(0, val.length()-1);
                    tv_main.setText(val);
                }
            }
        });
        bt_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOperatorClick("+");
            }
        });
        bt_min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOperatorClick("-");
            }
        });
        bt_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOperatorClick("÷");
            }
        });
        bt_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOperatorClick("×");
            }
        });

        bt_sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = tv_main.getText().toString();
                double res = Math.sqrt(Double.parseDouble(val));
                tv_main.setText(String.valueOf(res));
            }
        });
        btb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String expression = tv_main.getText().toString();

                if (expression.charAt(expression.length() - 1) == ')' || Character.isDigit(expression.charAt(expression.length() - 1))) {
                    tv_main.setText(expression + "×(");
                } else {
                    tv_main.setText(expression + "(");
                }
            }
        });
        btb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String expression = tv_main.getText().toString();
                int openBracketCount = 0;
                int closeBracketCount = 0;

                // Подсчет количества открывающих и закрывающих скобок
                for (char c : expression.toCharArray()) {
                    if (c == '(') {
                        openBracketCount++;
                    } else if (c == ')') {
                        closeBracketCount++;
                    }
                }

                // Проверка на то, что количество закрывающих скобок не превышает количество открывающих
                if (openBracketCount > closeBracketCount && (expression.isEmpty() || Character.isDigit(expression.charAt(expression.length() - 1)) || expression.charAt(expression.length() - 1) == ')')) {
                    tv_main.setText(expression + ")");
                }
            }
        });
        bt_pi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_sec.setText(bt_pi.getText());
                tv_main.setText(tv_main.getText()+pi);
            }
        });
        bt_sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String expression = tv_main.getText().toString();

                //  '*' перед sin, если предыдущий символ - цифра
                if (!expression.isEmpty()) {
                    char lastChar = expression.charAt(expression.length() - 1);
                    if (Character.isDigit(lastChar) || lastChar==')') {
                        tv_main.setText(expression + "×sin");
                    } else {
                        tv_main.setText(expression + "sin");
                    }
                } else {
                    tv_main.setText("sin");
                }
            }
        });
        bt_cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String expression = tv_main.getText().toString();

                if (!expression.isEmpty()) {
                    char lastChar = expression.charAt(expression.length() - 1);
                    if (Character.isDigit(lastChar) || lastChar==')') {
                        tv_main.setText(expression + "×cos");
                    } else {
                        tv_main.setText(expression + "cos");
                    }
                } else {
                    tv_main.setText("cos");
                }
            }
        });
        bt_tg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String expression = tv_main.getText().toString();

                if (!expression.isEmpty()) {
                    char lastChar = expression.charAt(expression.length() - 1);
                    if (Character.isDigit(lastChar) || lastChar==')') {
                        tv_main.setText(expression + "×tg");
                    } else {
                        tv_main.setText(expression + "tg");
                    }
                } else {
                    tv_main.setText("tg");
                }
            }
        });
        bt_ctg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String expression = tv_main.getText().toString();

                if (!expression.isEmpty()) {
                    char lastChar = expression.charAt(expression.length() - 1);
                    if (Character.isDigit(lastChar) || lastChar==')') {
                        tv_main.setText(expression + "×ctg");
                    } else {
                        tv_main.setText(expression + "ctg");
                    }
                } else {
                    tv_main.setText("ctg");
                }
            }
        });
        bt_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String expression = tv_main.getText().toString();

                if (!expression.isEmpty()) {
                    char lastChar = expression.charAt(expression.length() - 1);
                    if (Character.isDigit(lastChar) || lastChar==')') {
                        tv_main.setText(expression + "×log");
                    } else {
                        tv_main.setText(expression + "log");
                    }
                } else {
                    tv_main.setText("log");
                }
            }
        });
        bt_square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double number = Double.parseDouble(tv_main.getText().toString());
                tv_main.setText(String.valueOf(Math.pow(number, 2)));
                tv_sec.setText(number+"²");
            }
        });
//        bt_sqrt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                double number = Double.parseDouble(tv_main.getText().toString());
//                tv_main.setText(String.valueOf(Math.sqrt(number)));
//                tv_sec.setText("√"+number);
//            }
//        });
        bt_inv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_main.setText(tv_main.getText()+"^"+"(-1)");
            }
        });
        bt_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = tv_main.getText().toString();
                String replacedStr = val.replace('÷', '/').replace('×','*');
                try {
                    double result = eval(replacedStr);
                    tv_main.setText(String.valueOf(result));
                    tv_sec.setText(val);
                } catch (RuntimeException e) {
                    Toast.makeText(MainActivity.this, "Hекорректное выражение", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void handleOperatorClick(String operator) {
        String expression = tv_main.getText().toString();

        // Проверяем, если строка пустая или у нас (, то не добавляем оператор
        if (expression.isEmpty() || expression.charAt(expression.length() - 1) == '(') {
            return;
        }

        // Проверяем, если последний символ в строке является оператором,
        // то заменяем его на новый оператор
        if (isOperator(expression.charAt(expression.length() - 1))) {
            // Удаляем последний символ (старый оператор)
            expression = expression.substring(0, expression.length() - 1);
        }

        // Добавляем новый оператор к текущему выражению
        tv_main.setText(expression + operator);

    }
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '×' || c == '÷';
    }


    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tg")) x = Math.tan(Math.toRadians(x));
                    else if (func.equals("ctg")) x = 1/Math.tan(Math.toRadians(x));
                    else if (func.equals("log")) x = Math.log10(x);
                    else if (func.equals("ln")) x = Math.log(x);
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }
}
