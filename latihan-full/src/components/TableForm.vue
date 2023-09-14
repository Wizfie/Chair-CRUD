<template>
  <div>
    <router-link to="/">
      <button id="myButton" class="btn btn-primary m-3">Back</button>
    </router-link>
    <div>
      <div
        class="p-4 border border-primary"
        style="width: fit-content; margin: auto; margin-top: 5%"
      >
        <div>
          <h1 class="text-center">Add Student</h1>
        </div>
        <form @submit.prevent="inputStudent">
          <div class="form-row d-flex">
            <div class="col-md-6 mb-3">
              <label for="nama">Student Name</label>
              <input
                v-model="studentData.nama"
                type="text"
                class="form-control"
                id="nama"
                name="nama"
                placeholder="Full Name"
                value=""
              />
              <div class="text-danger" v-if="errors.nama">
                {{ errors.nama }}
              </div>
            </div>
            <div class="col-md-6 mb-3">
              <label for="softskill">Soft Skill</label>
              <input
                v-model="studentData.soft_skill"
                type="text"
                class="form-control"
                id="softskill"
                name="softskill"
                placeholder=""
                value=""
              />
              <div class="text-danger" v-if="errors.soft_skill">
                {{ errors.soft_skill }}
              </div>
            </div>
          </div>

          <div class="form-row">
            <div class="col-md-3 mb-3">
              <label for="age">Student Age</label>
              <input
                v-model="studentData.umur"
                type="number"
                class="form-control"
                id="age"
                name="age"
                placeholder="Age"
                value=""
              />
              <div class="text-danger" v-if="errors.umur">
                {{ errors.umur }}
              </div>
            </div>
            <div class="col-md-3 mb-3">
              <label for="Gender">Gender</label>
              <select
                v-model="studentData.jenis_kelamin"
                class="custom-select"
                id="Gender"
                name="Gender"
              >
                <option value="Male">Male</option>
                <option value="Female" selected>Female</option>
              </select>
              <div class="text-danger" v-if="errors.jenis_kelamin">
                {{ errors.jenis_kelamin }}
              </div>
            </div>
            <div class="col-md-6 mb-3">
              <label for="hardskill">Hard Skill</label>
              <input
                v-model="studentData.hard_skill"
                type="text"
                class="form-control"
                id="hardskill"
                name="hardskill"
                placeholder=""
                value=""
              />
              <div class="text-danger" v-if="errors.hard_skill">
                {{ errors.hard_skill }}
              </div>
            </div>
          </div>

          <div class="form-row">
            <div class="col mb-6">
              <label for="Email">Email</label>
              <input
                v-model="studentData.email"
                type="text"
                class="form-control"
                name="Email"
              />
              <div class="text-danger" v-if="errors.email">
                {{ errors.email }}
              </div>
            </div>

            <div class="col mb-6">
              <label for="Interest">Interest</label>

              <select
                v-model="studentData.interest"
                class="custom-select"
                id="Interest"
                name="Interest"
              >
                <option value="Web Frontend" selected>Web Frontend</option>
                <option value="Web Backend">Web Backend</option>
                <option value="Mobile Apps">Mobile Apps</option>
                <option value="Network">Network</option>
                <option value="Data Science">Data Science</option>
              </select>
              <div class="text-danger" v-if="errors.interest">
                {{ errors.interest }}
              </div>
            </div>
          </div>
          <div class="form-col mt-3">
            <div>
              <label for="Description">Description</label>
            </div>
            <div>
              <div class="text-danger" v-if="errors.deskripsi_diri">
                {{ errors.deskripsi_diri }}
              </div>
              <textarea
                v-model="studentData.deskripsi_diri"
                name="Description"
                id="Description"
                cols="75"
                rows="5"
                maxlength="255"
              ></textarea>
            </div>
          </div>
          <div>
            <button id="btn-submit" type="submit" class="btn btn-secondary">
              {{ buttonValue }}
            </button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import studentService from "../Services/studentService.js";
// import SuccessForm from "./SuccessForm.vue"
import Swal from "sweetalert2";

export default {
  data() {
    return {
      studentData: {
        deskripsi_diri: null,
        nama: null,
        email: null,
        hard_skill: null,
        soft_skill: null,
        umur: null,
        interest: null,
        jenis_kelamin: null,
      },
      errors: {
        deskripsi_diri: null,
        nama: null,
        email: null,
        hard_skill: null,
        soft_skill: null,
        umur: null,
        interest: null,
        jenis_kelamin: null,
      },
      success: false,
      buttonValue: "Submit",
    };
  },
  methods: {
    inputStudent() {
      let data = this.studentData;
      if (this.buttonValue === "Submit") {
        if (this.validateForm()) {
          studentService.create(data).then((response) => {
            console.log(response.data);
          });
          Swal.fire({
            position: "center",
            icon: "success",
            title: "Your work has been saved",
            timer: 2000,
            timerProgressBar: true,
          }).then(() => {
            this.$router.push("/");
          });
        }
      } else {
        if (this.validateForm()) {
          studentService.updateStudent(data.id, data).then((response) => {
            console.log(response.data);
          });
          Swal.fire({
            position: "center",
            icon: "success",
            title: "Your work has been saved",
            timer: 2000,
            timerProgressBar: true,
          }).then(() => {
            this.$router.push("/");
          });
        }
      }
    },
    getStudentId(id) {
      studentService
        .updateStudentId(id)
        .then((response) => {
          this.studentData = response.data;
        })

        .catch((e) => {
          console.log(e);
        });
    },
    validateForm() {
      let valid = true;
      const data = this.studentData;
      const errorMessages = {
        deskripsi_diri: "Deskripsi Diri is required.",
        nama: "Student Name is required.",
        email: "Email is required.",
        hard_skill: "Hard Skill is required.",
        soft_skill: "Soft Skill is required.",
        umur: "Student Age is required.",
        interest: "Interest is required.",
        jenis_kelamin: "Gender is required.",
      };

      for (const field in data) {
        if (!data[field]) {
          this.errors[field] = errorMessages[field];
          valid = false;
        } else {
          this.errors[field] = null;
        }
      }

      return valid;
    },
  },

  components: {
    // SuccessForm,
  },
  mounted() {
    if (this.$route.name == "updateData") {
      this.getStudentId(this.$route.params.id);
      this.buttonValue = "Update";
    }
  },
  watch: {
    studentDataProps(newValue) {
      this.studentData = newValue;
      console.log(this.studentData);
      this.buttonValue = "Update";
    },
  },
};
</script>

<style>
#btn-submit {
  display: flex;
  margin: 0 auto;
  margin-top: 12px;
}
</style>
