window.onload = function() {

    var keys         = document.getElementsByTagName('button'),
        operators    = ['/', '*', '-', '+', '%'],
        lastOperator = '',
        decimalAdded = false;
    
    for (var i = 0; i < keys.length; i++) {

        keys[i].onclick = function() {

            var keyValue    = this.innerHTML,
                detail      = document.getElementById('detail'),
                detailValue = detail.innerHTML,
                lastChar    = detailValue[detailValue.length - 1],
                result      = document.getElementById('result-value');
            switch (keyValue) {
                case 'C':
                    result.innerHTML = '0';
                    detail.innerHTML = '';
                    break;
                case '=':
                    if (detail.innerHTML != '') {
                        result.innerHTML = eval(detailValue);
                        decimalAdded = false;
                    }
                    break;
                case '/':
                case '*':
                case '-':
                case '+':
                case '%':
                    if (detailValue != '' && operators.indexOf(lastChar) == -1) {
                        detail.innerHTML += keyValue;
                    } else {
                        detail.innerHTML = detail.innerHTML.replace(/.$/, keyValue);
                    }

                    decimalAdded = false;
                    lastOperator = keyValue;
                    break;
                case 'del':
                    if (lastChar == '.') {
                        decimalAdded = false;   
                    }

                    detail.innerHTML = detail.innerHTML.replace(/.$/, '');
                    break;
                case '.':
                    if ( ! decimalAdded) {
                        detail.innerHTML += keyValue;
                        decimalAdded = true;
                    }
                    break;
                case '+/-':                    break;
                
                default:
                    detail.innerHTML += keyValue;
                    break;
            }
        }
    }
}
