import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:3000"
});

export default {

  list() {
    return http.get('/topics');
  },

  get(id) {
    return http.get(`/topics/${id}`);
  },

  createTopic(newTopic){
    return http.post('/topics', newTopic)
  },

  updateTopic(id, topicTitle){
    return http.put(`/topics/${id}`, topicTitle)
  },

  deleteTopic(id){
    return http.delete(`/topics/${id}`)
  }

}
