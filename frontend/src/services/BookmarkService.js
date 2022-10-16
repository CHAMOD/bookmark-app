import axios from "axios";
const resourceUrl = "http://localhost:8080/v1/bookmarks";


const headers = {
  'Access-Control-Allow-Origin': '*',
  'Access-Control-Allow-Methods': 'POST, PATCH, PUT, DELETE, OPTIONS',
  'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token',
  'Access-Control-Allow-Credentials': true
}
const BookmarkAPI = {

  
  updateBookmark: function (bookmark) {
    return axios.put(resourceUrl + `/`,  bookmark,{
      headers: headers
    },
      { withCredentials: true },
      { crossorigin: true }).catch(error => {
      console.log(error);
    });
  },
  deleteBookmark: function (bookmarkId) {
    return axios.get(resourceUrl + `/delete/`+bookmarkId, {
      headers: headers
    },
      { withCredentials: true },
      { crossorigin: true }).catch(error => {
      console.log(error);
    }).catch(error => {
      console.log(error);
    });
  }
  ,
  getAllBookMarks: function () {
    return axios.get(resourceUrl + `/`, {
      headers: headers
    },
      { withCredentials: true },
      { crossorigin: true }).catch(error => {
      console.log(error);
    }).catch(error => {
      console.log(error);
    });
  }
  ,
  extractAllBookmarks: function () {
    return axios.get(resourceUrl + `/extractAllBookmarks`, {
      headers: headers
    },
      { withCredentials: true },
      { crossorigin: true }).catch(error => {
      console.log(error);
    }).catch(error => {
      console.log(error);
    });
  }
};

export default BookmarkAPI;
