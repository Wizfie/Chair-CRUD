<template>
  <div class="d-flex align-content-start flex-wrap">
    <div v-for="(item, index) in studentData" :key="item.id">
      <div
        class="card border border-primary d-flex m-3"
        style="width: 18rem; height: fit-content"
      >
        <div class="card-body">
          <p class="d-none">
            {{ index + 1 }}
          </p>
          <h4 class="card-title text-center">{{ item.nama }}</h4>
          <h6 class="card-subtitle mb-4 text-center">
            {{ item.umur + " " + "Year Old" }}
          </h6>
          <hr />
          <p class="card-text mb-5">{{ item.deskripsi_diri }}</p>

          <p class="card-subtitle mb-2">{{ "Email :" + " " + item.email }}</p>
          <p class="card-subtitle mb-2">
            {{ "Soft Skill :" + " " + item.soft_skill }}
          </p>
          <p class="card-subtitle mb-2">
            {{ "Hard Skill :" + " " + item.hard_skill }}
          </p>
          <p class="card-subtitle mb-3">
            {{ "Interest :" + " " + item.interest }}
          </p>

          <div class="card-action">
            <router-link :to="{ name: 'updateData', params: { id: item.id } }">
              <button class="btn btn-sm btn-warning mr-2 text-white">
                Update
              </button>
            </router-link>

            <button
              class="btn btn-sm btn-danger"
              @click="deleteStudentFunc(item.id)"
            >
              Delete
            </button>
            <img
              style="width: 13%; margin-left: 10%"
              src="../assets/female.png"
              alt=""
              v-show="item.jenis_kelamin === 'Female'"
            />
            <img
              style="width: 20%; margin-left: 10%"
              src="../assets/male.png"
              alt=""
              v-show="item.jenis_kelamin === 'Male'"
            />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import StudentService from "../Services/studentService";
import Swal from "sweetalert2";
export default {
  name: "CardData",
  methods: {
    getStudent() {
      StudentService.getAll()
        .then((response) => {
          this.studentData = response.data;
          console.log(this.studentData);
        })
        .catch((e) => {
          console.log(e);
        });
    },

    deleteStudentFunc(id, index) {
      const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
          confirmButton: "btn btn-success ",
          cancelButton: "btn btn-danger ",
        },
        buttonsStyling: true,
      });

      swalWithBootstrapButtons
        .fire({
          title: "Are you sure?",
          text: "You won't be able to revert this!",
          icon: "warning",
          showCancelButton: true,
          confirmButtonText: "Yes, delete it!",
          cancelButtonText: "No, cancel!",
          reverseButtons: true,
        })
        .then((result) => {
          if (result.isConfirmed) {
            StudentService.deleteStudent(id)
              .then((response) => {
                console.log(response.data);
                this.studentData.splice(index, 1);
                this.getStudent();
              })
              .catch((e) => {
                console.log(e.response.data);
              });
            swalWithBootstrapButtons.fire(
              "Deleted!",
              "Your file has been deleted.",
              "success"
            );
          } else if (result.dismiss === Swal.DismissReason.cancel) {
            swalWithBootstrapButtons.fire(
              "Cancelled",
              "Your imaginary file is safe :)",
              "error"
            );
          }
        });
    },
  },
  mounted() {
    this.getStudent();
  },
  data() {
    return {
      studentData: null,
    };
  },
};
</script>

<style></style>
