<template>
  <div id="app">
    <table class="table table-dark">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">First</th>
          <th scope="col">Last</th>
          <th scope="col">Handle</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <th scope="row">1</th>
          <td>Mark</td>
          <td>Otto</td>
          <td>@mdo</td>
        </tr>
        <tr>
          <th scope="row">2</th>
          <td>Jacob</td>
          <td>Thornton</td>
          <td>@fat</td>
        </tr>
        <tr>
          <th scope="row">3</th>
          <td>Larry</td>
          <td>the Bird</td>
          <td>@twitter</td>
        </tr>
      </tbody>
    </table>
    <button id="teste">teste</button>
  </div>
</template>

<script>
import api from '../src/services/api.js';

    api.get("item")
      .then((function(response){
        console.log(response.data)
      }))
      .catch((err) => {
        console.error("ops! ocorreu um erro" + err);
    });

export default {

  created() {
    
  }
}
</script>
