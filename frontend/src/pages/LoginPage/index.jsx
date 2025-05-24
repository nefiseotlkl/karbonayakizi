import React from "react";
import closedEye from "./closedeye.png";
import fluentCheckboxChecked16Filled from "./fluent_checkbox-checked-16-filled.png";
import image1 from "./image1.png";
import line1 from "./line1.png";
import line2 from "./line2.png";
import "./style.css";
import untitledDesign221 from "./Untitled.png";
export const Desktop = () => {
  return (
    <div className="desktop">
      <div className="rectangle">
        <div className="overlap-group">
          {/* image kaldırıldı, background-image kullanılıyor */}
          {/* <img className="image" alt="Image" src={image1} /> */}

          <img
            className="untitled-design"
            alt="Untitled design"
            src={untitledDesign221}
          />

         
          <div className="SIGNUP">
            <div className="text-wrapper">SIGN UP</div>
          </div>


          <div className="frame">
            <div className="div">
              <div className="upper-section">
                <div className="login-text">
                  <div className="text-wrapper-2">Welcome Back</div>

                  <div className="text-wrapper-3">Glad you’re back.!</div>
                </div>

                <div className="credentials">
                  <div className="username">
                    <div className="text-wrapper-4">Username</div>
                  </div>

                  <div className="password-rem">
                    <div className="password">
                      <div className="text-wrapper-4">Password</div>

                      <img className="img" alt="Closed eye" src={closedEye} />
                    </div>

                    <div className="remember">
                      <img
                        className="img"
                        alt="Fluent checkbox"
                        src={fluentCheckboxChecked16Filled}
                      />

                      <div className="text-wrapper-5">Remember me</div>
                    </div>
                  </div>

                  <div className="login-bt-fp">
                    <div className="login">
                      <div className="text-wrapper">Login</div>
                    </div>

                    <div className="text-wrapper-3">Forgot password ?</div>
                  </div>
                </div>
              </div>

              <div className="other-logins">
                <div className="or">
                  <img className="line" alt="Line" src={line1} />

                  <div className="text-wrapper-6">Or</div>

                  <img className="line" alt="Line" src={line2} />
                </div>
              </div>
            </div>

            <div className="frame-2">
              <p className="text-wrapper-5">Don’t have an account ? Signup</p>

              <div className="customer-care">
                <div className="div-wrapper">
                  <div className="text-wrapper-7">Terms &amp; Conditions</div>
                </div>

                <div className="div-wrapper">
                  <div className="text-wrapper-7">Support</div>
                </div>

                <div className="div-wrapper">
                  <div className="text-wrapper-7">Customer Care</div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};
