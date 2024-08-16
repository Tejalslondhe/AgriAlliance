import React, { useState } from 'react';
import '../styles/FAQPage.css';

const FAQPage = () => {
  const [openIndex, setOpenIndex] = useState(null);

  const toggleFAQ = (index) => {
    setOpenIndex(openIndex === index ? null : index);
  };

  const faqData = [
    {
      question: "What is AgriAlliance?",
      answer: "AgriAlliance is a platform connecting farmers, workers, merchants, and agronomists to enhance agricultural productivity and efficiency."
    },
    {
      question: "How do I register?",
      answer: "You can register by selecting your role on the Role Selection Page and following the registration process."
    },
    {
      question: "How can I book an instrument?",
      answer: "Once registered, you can browse available instruments and book them through the dashboard specific to your role."
    },
    {
      question: "What services do you offer?",
      answer: "We offer a range of services including connecting with workers, renting instruments, and access to expert agronomists."
    },
    {
      question: "How can I contact customer support?",
      answer: "You can reach our customer support through the Contact Us page or by emailing agroalliance@gmail.com."
    }
  ];

  return (
    <div className="faq-container">
      <h2 className="faq-title">Frequently Asked Questions</h2>
      <div className="faq-list">
        {faqData.map((item, index) => (
          <div key={index} className="faq-item">
            <div className="faq-question" onClick={() => toggleFAQ(index)}>
              {item.question}
              <span className="faq-toggle">{openIndex === index ? '-' : '+'}</span>
            </div>
            {openIndex === index && <div className="faq-answer">{item.answer}</div>}
          </div>
        ))}
      </div>
    </div>
  );
};

export default FAQPage;
