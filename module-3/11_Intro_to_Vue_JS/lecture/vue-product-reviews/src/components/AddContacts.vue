<template>
  <div id="addemail">
      <h1>Add Email</h1>
      <div>
          <label for="name">
              Name: <input type="text" v-model="name">
          </label>
          <label for="email">
              Email: <input type="text" v-model="email">
          </label>
          <label for="emailType">
              Email Type:
              <select v-model="emailType">
                <option value="HOME">Home</option>
                <option value="WORK">Work</option>
                <option value="OTHER">Other</option>
              </select>
          </label>
      </div>
      <div>
          <h2>You Selected</h2>
          <div>
              Name: {{name}}
          </div>
          <div>
              Email: {{email}}
          </div>
          <div>
              Email Type: {{emailType}}
          </div>
      </div>
  </div>
</template>

<script>
export default {
    name: 'add-contacts',
    data(){
        return {
            name: '',
            email: '',
            emailType: ''
        }
    }
}
</script>

<style>

</style>