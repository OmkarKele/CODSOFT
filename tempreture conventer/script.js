function convertTemperature() {
  const tempInput = document.getElementById('temp-input');
  const originalUnit = document.getElementById('original-unit').value;
  const targetUnit = document.getElementById('target-unit').value;
  const resultDiv = document.getElementById('result');
  var lblLabel = document.getElementById('lbl');
  let result;
  switch (originalUnit) {
    case 'celsius':
      switch (targetUnit) {
        case 'celsius':
          result = tempInput.value;
          break;
        case 'fahrenheit':
          result = (parseFloat(tempInput.value) * 9/5) + 32;
          break;
        case 'kelvin':
          result = parseFloat(tempInput.value) + 273.15;
          break;
      }
      break;
    case 'fahrenheit':
      switch (targetUnit) {
        case 'celsius':
          result = (parseFloat(tempInput.value) - 32) * 5/9;
          break;
        case 'fahrenheit':
          result = tempInput.value;
          break;
        case 'kelvin':
          result = (parseFloat(tempInput.value) + 459.67) * 5/9;
          break;
      }
      break;
    case 'kelvin':
      switch (targetUnit) {
        case 'celsius':9
          result = parseFloat(tempInput.value) - 273.15;
          break;
        case 'fahrenheit':
          result = (parseFloat(tempInput.value) * 9/5) - 459.67;
          break;
        case 'kelvin':
          result = tempInput.value;
          break;
      }
      break;
  }
  resultDiv.innerHTML = `${tempInput.value} ${originalUnit} = ${result.toFixed(2)} ${targetUnit}`;
}
const convertBtn = document.getElementById('convert-btn');
convertBtn.addEventListener('click', convertTemperature);