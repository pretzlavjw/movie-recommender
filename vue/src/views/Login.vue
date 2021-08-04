<template>
  <div id="login" class="text-center styles">
    <div id="description">Don't know what to watch? We have you covered. 
      As you favorite movies you like and skip the ones you don't, this app will recommend movies for you to watch. 
      If you find one that you haven't seen, add it to a list to watch later.</div>
    <form class="form-signin" @submit.prevent="login">
      <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <div class="username-well">
        <label for="username" class="sr-only">Username: </label>
        <input
          type="text"
          id="username"
          class="form-control"
          placeholder="Username"
          v-model="user.username"
          required
          autofocus
        />
      </div>
      <div class="password-well">
        <label for="password" class="sr-only">Password: </label>
        <input
          type="password"
          id="password"
          class="form-control"
          placeholder="Password"
          v-model="user.password"
          required
        />
      </div>
      <router-link :to="{ name: 'register' }">Need an account?</router-link>
      <button type="submit">Sign in</button>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style>
  @import '../resources/styles.css';
  .form-signin {
    display: flex;
    height: 100vh;
    flex-direction: column;
    height: 20rem;
    align-items: center;
    align-content: center;
    flex-wrap: wrap;
    justify-content: space-around;
    justify-self: center;
    margin: 1rem 0,
    
  }

  #description {
    display: inline-flex;
    flex-wrap: wrap;
    margin-left: 200px;
    margin-right: 200px;
    margin-top: 40px;
    text-align: center;


  }
</style>
